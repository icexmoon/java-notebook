package ch20.extract_interface2;

import java.io.IOException;
import java.io.Writer;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.util.SimpleElementVisitor14;
import javax.tools.JavaFileObject;

public class ExtractInterfaceProcessor extends AbstractProcessor {
    private ProcessingEnvironment processingEnv;
    private boolean handled = false;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        this.processingEnv = processingEnv;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (Element element : roundEnv.getRootElements()) {
            element.accept(new ExtractInterfaceVisitor(), null);
        }
        return handled;
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> annocationTypes = new HashSet<>();
        annocationTypes.add(ExtractInterface.class.getCanonicalName());
        return annocationTypes;
    }

    private static String executableElementStr(ExecutableElement element) {
        StringBuilder sb = new StringBuilder();
        sb.append("    public ");
        sb.append(element.getReturnType());
        sb.append(" ");
        sb.append(element.getSimpleName());
        sb.append(" (");
        List<? extends VariableElement> parameters = element.getParameters();
        if (parameters.size() > 0) {
            for (VariableElement parameter : parameters) {
                sb.append(parameter.asType());
                sb.append(" ");
                sb.append(parameter.getSimpleName());
                sb.append(",");
            }
            sb.delete(sb.length() - 1, sb.length());
        }
        sb.append(");\n");
        return sb.toString();
    }

    private class ExtractInterfaceVisitor extends SimpleElementVisitor14<Object, Object> {

        @Override
        public Object visitExecutable(ExecutableElement e, Object p) {
            return super.visitExecutable(e, p);
        }

        @Override
        public Object visitType(TypeElement classElement, Object p) {
            StringBuilder sb = new StringBuilder();
            ExtractInterface extractInterface = classElement.getAnnotation(ExtractInterface.class);
            if (extractInterface != null) {
                String interfaceName = extractInterface.value();
                sb.append("package ch20.extract_interface2;\n\n");
                sb.append("public interface ");
                sb.append(interfaceName);
                sb.append("{\n");
                for (Element element : classElement.getEnclosedElements()) {
                    if (element.getKind() == ElementKind.METHOD) {
                        if (!element.getModifiers().contains(Modifier.PUBLIC)) {
                            continue;
                        }
                        ExecutableElement executableElement = (ExecutableElement) element;
                        sb.append(executableElementStr(executableElement));
                    }
                }
                sb.append("}");
                try {
                    JavaFileObject file = processingEnv.getFiler().createSourceFile(interfaceName);
                    Writer writer = file.openWriter();
                    writer.write(sb.toString());
                    writer.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                handled = true;
            }
            return null;
        }

    }
}
