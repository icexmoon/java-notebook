package main

import "fmt"

type addable interface {
	add(int)
	clear()
	toString() string
}

type handler struct {
	obj int
}

func (h *handler) add(item int) {
	h.obj = item
}

func (h *handler) clear() {
	h.obj = 0
}

func (h *handler) toString() string {
	return fmt.Sprintf("handler(%d)", h.obj)
}

type query struct {
	list []int
}

func (q *query) add(item int) {
	q.list = append(q.list, item)
}

func (q *query) clear() {
	q.list = nil
}

func (q *query) toString() string {
	return fmt.Sprintf("query(%v)", q.list)
}

func main() {
	test(&handler{})
	test(&query{})
}

func test(add addable) {
	add.clear()
	for i := 0; i < 10; i++ {
		add.add(i)
	}
	print(add.toString() + "\n")
}

// handler(9)
// query([0 1 2 3 4 5 6 7 8 9])
