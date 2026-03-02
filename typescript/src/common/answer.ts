interface AocContext {
  year: number;
  day: number;
  part?: number;
}

function formatPrefix({ year, day, part }: AocContext): string {
  const dayStr = String(day).padStart(2, "0");
  const partStr = part ? ` [Part ${part}]` : "";
  return `[AOC ${year}] [Day ${dayStr}]${partStr}`;
}

export function answer<T>(ctx: AocContext, result: T): void {
  console.log(`${formatPrefix(ctx)} ${result}`);
}

export function verify<T>(ctx: AocContext, expected: T, actual: T): void {
  const status =
    expected === actual
      ? "PASS"
      : `FAIL (expected: ${expected}, actual: ${actual})`;
  console.log(`${formatPrefix(ctx)} ${status}`);
}