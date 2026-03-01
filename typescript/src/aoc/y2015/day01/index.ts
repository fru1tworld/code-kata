import { answerPart, input, verifyPart } from '../../../common/index.js';

type Instruction = {
  char: string;
  change: number;
};

const instructions: Instruction[] = [
  { char: '(', change: 1 },
  { char: ')', change: -1 },
];

function getChange(c: string): number {
  return instructions.find((i) => i.char === c)?.change ?? 0;
}

function solve(data: string): number {
  return [...data].map(getChange).reduce((acc, v) => acc + v, 0);
}

const data = input(2015, 1);

let result = 0;
for (const c of data) {
  if (c === '(') {
    result++;
  } else if (c === ')') {
    result--;
  }
}

const refactored = solve(data);

answerPart(2015, 1, 1, result);
verifyPart(2015, 1, 1, result, refactored);
