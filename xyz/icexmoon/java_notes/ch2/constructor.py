from typing import Any

class MyClass:
    def __new__(cls: Any) -> Any:
        print("MyClass is build.")
        return super().__new__(cls)

    def __init__(self):
        print("MyClass is inited.")


mc = MyClass()
# MyClass is build.
# MyClass is inited.
