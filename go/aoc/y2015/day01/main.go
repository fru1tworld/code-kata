package main

import "code-kata/common"

type Instruction struct {
	char   rune
	change int
}

var instructions = []Instruction{
	{'(', 1},
	{')', -1},
}

func getChange(c rune) int {
	for _, inst := range instructions {
		if inst.char == c {
			return inst.change
		}
	}
	return 0
}

func solve(input string) int {
	floor := 0
	for _, c := range input {
		floor += getChange(c)
	}
	return floor
}

func main() {
	input := common.Input(2015, 1)

	result := 0
	for _, c := range input {
		switch c {
		case '(':
			result++
		case ')':
			result--
		}
	}

	refactored := solve(input)

	common.AnswerPart(2015, 1, 1, result)
	common.VerifyPart(2015, 1, 1, result, refactored)
}
