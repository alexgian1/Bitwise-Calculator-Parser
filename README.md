# Bitwise-Calculator-Parser
The calculator accepts expressions with the bitwise AND(&amp;) and XOR(^) operators, as well as parentheses. (Single digit numbers only)

#### Initial grammar:
```
exp -> num | exp op exp | (exp)

op -> ^ | &

num -> 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9
```

#### LL(1) grammar with priority:
```
exp -> term exp2

exp2 -> ^ term exp2 | ε

term -> exp3 term2

term2 -> & exp3 term2 | ε

exp3 -> num | (exp)

num -> 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9
```

## Execution
```
javac Parser.java
java Parser
```

## Input examples
```
1&2^2&3

1&2^(2&3^4)

2^3&(2&4^(3&3^(8&4)))^2
```
