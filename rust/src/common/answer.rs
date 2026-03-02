use std::fmt::Display;

fn format_prefix(year: u32, day: u32, part: Option<u32>) -> String {
    match part {
        Some(p) => format!("[AOC {}] [Day {:02}] [Part {}]", year, day, p),
        None => format!("[AOC {}] [Day {:02}]", year, day),
    }
}

pub fn answer<T: Display>(year: u32, day: u32, part: Option<u32>, result: T) {
    println!("{} {}", format_prefix(year, day, part), result);
}

pub fn answer_part<T: Display>(year: u32, day: u32, part: u32, result: T) {
    answer(year, day, Some(part), result);
}

pub fn verify<T: Display + PartialEq>(
    year: u32,
    day: u32,
    part: Option<u32>,
    expected: T,
    actual: T,
) {
    let status = if expected == actual {
        "PASS".to_string()
    } else {
        format!("FAIL (expected: {}, actual: {})", expected, actual)
    };
    println!("{} {}", format_prefix(year, day, part), status);
}

pub fn verify_part<T: Display + PartialEq>(year: u32, day: u32, part: u32, expected: T, actual: T) {
    verify(year, day, Some(part), expected, actual);
}
