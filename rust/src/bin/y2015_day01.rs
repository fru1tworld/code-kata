use code_kata::common::{answer_part, input, verify_part};

enum Instruction {
    Up,
    Down,
    Stay,
}

impl Instruction {
    fn from_char(c: char) -> Self {
        match c {
            '(' => Instruction::Up,
            ')' => Instruction::Down,
            _ => Instruction::Stay,
        }
    }

    fn change(&self) -> i32 {
        match self {
            Instruction::Up => 1,
            Instruction::Down => -1,
            Instruction::Stay => 0,
        }
    }
}

fn solve(input: &str) -> i32 {
    input
        .chars()
        .map(Instruction::from_char)
        .map(|i| i.change())
        .sum()
}

fn main() {
    let input = input(2015, 1);

    let result: i32 = input
        .chars()
        .map(|c| match c {
            '(' => 1,
            ')' => -1,
            _ => 0,
        })
        .sum();

    let refactored = solve(&input);

    answer_part(2015, 1, 1, result);
    verify_part(2015, 1, 1, result, refactored);
}
