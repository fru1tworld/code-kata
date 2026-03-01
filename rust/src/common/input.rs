use std::fs;
use std::path::PathBuf;

fn get_input_path(year: u32, day: u32) -> PathBuf {
    let manifest_dir = env!("CARGO_MANIFEST_DIR");
    PathBuf::from(manifest_dir)
        .parent()
        .unwrap()
        .join("inputs")
        .join(format!("{}", year))
        .join(format!("day{:02}", day))
        .join("input.txt")
}

pub fn input(year: u32, day: u32) -> String {
    let path = get_input_path(year, day);
    fs::read_to_string(&path)
        .unwrap_or_else(|_| panic!("Input file not found: {:?}", path))
        .trim()
        .to_string()
}

pub fn input_lines(year: u32, day: u32) -> Vec<String> {
    input(year, day).lines().map(String::from).collect()
}

pub fn input_lines_not_blank(year: u32, day: u32) -> Vec<String> {
    input_lines(year, day)
        .into_iter()
        .filter(|line| !line.trim().is_empty())
        .collect()
}
