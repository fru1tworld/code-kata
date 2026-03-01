function formatPrefix(year: number, day: number, part?: number): string {
  const dayStr = day.toString().padStart(2, '0');
  const partStr = part !== undefined ? ` [Part ${part}]` : '';
  return `[AOC ${year}] [Day ${dayStr}]${partStr}`;
}

export function answer<T>(year: number, day: number, part: number | undefined, result: T): void {
  console.log(`${formatPrefix(year, day, part)} ${result}`);
}

export function answerPart<T>(year: number, day: number, part: number, result: T): void {
  answer(year, day, part, result);
}

export function verify<T>(
  year: number,
  day: number,
  part: number | undefined,
  expected: T,
  actual: T
): void {
  const status = expected === actual ? 'PASS' : `FAIL (expected: ${expected}, actual: ${actual})`;
  console.log(`${formatPrefix(year, day, part)} ${status}`);
}

export function verifyPart<T>(
  year: number,
  day: number,
  part: number,
  expected: T,
  actual: T
): void {
  verify(year, day, part, expected, actual);
}
