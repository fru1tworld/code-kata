import { readFileSync } from 'node:fs';
import { dirname, join } from 'node:path';
import { fileURLToPath } from 'node:url';

const __dirname = dirname(fileURLToPath(import.meta.url));

function getInputPath(year: number, day: number): string {
  const dayStr = day.toString().padStart(2, '0');
  return join(__dirname, '..', '..', '..', 'inputs', `${year}`, `day${dayStr}`, 'input.txt');
}

export function input(year: number, day: number): string {
  const path = getInputPath(year, day);
  return readFileSync(path, 'utf-8').trim();
}

export function inputLines(year: number, day: number): string[] {
  return input(year, day).split('\n');
}

export function inputLinesNotBlank(year: number, day: number): string[] {
  return inputLines(year, day).filter((line) => line.trim() !== '');
}
