package ch20.extract_interface;

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
import javax.tools.JavaFileObject;

public class ExtractInterfaceProcessor extends AbstractProcessor {
    private ProcessingEnvironment processingEnv;

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
        StringBuilder sb = new StringBuilder();
        boolean handled = false;
        for (Element classElement : roundEnv.getElementsAnnotatedWith(ExtractInterface.class)) {
            if (classElement.getKind() != ElementKind.CLASS) {
                throw new RuntimeException("Annotation @ExtractInterface only be used in class.");
            }
            ExtractInterface extractInterface = classElement.getAnnotation(ExtractInterface.class);
            String interfaceName = extractInterface.value();
            sb.append("package ch20.extract_interface;\n\n");
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
}
