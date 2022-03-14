

class Base:
    def __init__(self, obj: object = None) -> None:
        super().__init__()
        self.obj = obj

    def getObj(self) -> object:
        return self.obj

    def setObj(self, obj: object) -> None:
        self.obj = obj


class Counter:

    def __init__(self) -> None:
        super().__init__()
        num: int = getattr(self.__class__, "num", 0)
        num += 1
        self.id: int = num
        setattr(self.__class__, "num", num)

    def getId(self) -> int:
        return self.id


class Mixin(Base, Counter):
    def __init__(self, obj: object = None) -> None:
        super().__init__(obj)


print(Mixin.__mro__)
mix: Mixin = Mixin()
print(mix.getId())
mix.setObj("hello")
print(mix.getObj())
# (<class '__main__.Mixin'>, <class '__main__.Base'>, <class '__main__.Counter'>, <class 'object'>)
# 1
# hello