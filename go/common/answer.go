package common

import "fmt"

func formatPrefix(year, day int, part *int) string {
	partStr := ""
	if part != nil {
		partStr = fmt.Sprintf(" [Part %d]", *part)
	}
	return fmt.Sprintf("[AOC %d] [Day %02d]%s", year, day, partStr)
}

func Answer[T any](year, day int, part *int, result T) {
	fmt.Printf("%s %v\n", formatPrefix(year, day, part), result)
}

func AnswerPart[T any](year, day, part int, result T) {
	Answer(year, day, &part, result)
}

func Verify[T comparable](year, day int, part *int, expected, actual T) {
	var status string
	if expected == actual {
		status = "PASS"
	} else {
		status = fmt.Sprintf("FAIL (expected: %v, actual: %v)", expected, actual)
	}
	fmt.Printf("%s %s\n", formatPrefix(year, day, part), status)
}

func VerifyPart[T comparable](year, day, part int, expected, actual T) {
	Verify(year, day, &part, expected, actual)
}
