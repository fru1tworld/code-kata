import { answer, input, verify } from "../../../common/index.js";

type Instruction = {
  char: string;
  change: number;
};

const instructions: Instruction[] = [
  { char: "(", change: 1 },
  { char: ")", change: -1 },
];

function getChange(c: string): number {
  return instructions.find((i) => i.char === c)?.change ?? 0;
}

function solve(data: string): number {
  return [...data].map(getChange).reduce((acc, v) => acc + v, 0);
}

const data = input(2015, 1);
const ctx = { year: 2015, day: 1, part: 1 };

let result = 0;
for (const c of data) {
  if (c === "(") {
    result++;
  } else if (c === ")") {
    result--;
  }
}

const refactored = solve(data);

answer(ctx, result);
verify(ctx, result, refactored);