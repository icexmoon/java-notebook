package main

import "fmt"

type Test struct{}
type StructDefine struct {
	IntMember   int
	FloatMember float64
	BoolMember  bool
	TestMember  Test
}

func main() {
	sd := StructDefine{}
	fmt.Printf("IntMember:%d\n", sd.IntMember)
	fmt.Printf("FloatMember:%.2f\n", sd.FloatMember)
	fmt.Printf("BoolMember:%v\n", sd.BoolMember)
	fmt.Println("TestMember:", sd.TestMember)
	var intLocal int
	var floatLocal float64
	var boolLocal bool
	var testLocal Test
	fmt.Println("intLocal:", intLocal)
	fmt.Println("floatLocal:", floatLocal)
	fmt.Println("boolLocal:", boolLocal)
	fmt.Println("testLocal:", testLocal)
}

// IntMember:0
// FloatMember:0.00
// BoolMember:false
// TestMember: {}
// intLocal: 0
// floatLocal: 0
// boolLocal: false
// testLocal: {}
