
from typing import Any


class Handler:
    def __init__(self) -> None:
        self.content = None

    def add(self, obj: Any) -> None:
        self.content = obj

    def clear(self) -> None:
        self.content = None

    def __str__(self) -> str:
        return "Handler({})".format(self.content)


class Query:
    def __init__(self) -> None:
        self.list = list()

    def add(self, obj: Any) -> None:
        self.list.append(obj)

    def clear(self) -> None:
        self.list.clear()

    def __iter__(self):
        return self.list.__iter__()

    def __str__(self) -> str:
        return "Query({})".format(self.list)


def test(addable):
    addable.clear()
    numbers: list = range(10)
    for i in numbers:
        addable.add(i)
    print(addable)


test(Handler())
test(Query())
# Handler(9)
# Query([0, 1, 2, 3, 4, 5, 6, 7, 8, 9])
