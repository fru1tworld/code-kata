package common

import (
	"fmt"
	"os"
	"path/filepath"
	"runtime"
	"strings"
)

func getInputPath(year, day int) string {
	_, file, _, _ := runtime.Caller(0)
	baseDir := filepath.Dir(filepath.Dir(filepath.Dir(file)))
	return filepath.Join(baseDir, "inputs", fmt.Sprintf("%d", year), fmt.Sprintf("day%02d", day), "input.txt")
}

func Input(year, day int) string {
	path := getInputPath(year, day)
	data, err := os.ReadFile(path)
	if err != nil {
		panic(fmt.Sprintf("Input file not found: %s", path))
	}
	return strings.TrimSpace(string(data))
}

func InputLines(year, day int) []string {
	return strings.Split(Input(year, day), "\n")
}

func InputLinesNotBlank(year, day int) []string {
	lines := InputLines(year, day)
	result := make([]string, 0, len(lines))
	for _, line := range lines {
		if strings.TrimSpace(line) != "" {
			result = append(result, line)
		}
	}
	return result
}
