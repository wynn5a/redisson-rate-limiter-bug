## Test with spring boot starter

output for 10 threads

```

Test -- 2 permit per 1 seconds
current keys: 
  myLimiter
Test start @ 1686808272429
T1 has failed
T2 has failed
T8 has failed
T7 has failed
T4 has failed
T6 has failed
T5 has failed
T0 has acquired, cost: 0 seconds
T3 has acquired, cost: 0 seconds
T9 has failed
T7 has failed
T1 has failed
T2 has failed
T8 has failed
T5 has failed
T6 has failed
T4 has failed
T9 has failed
T7 has acquired, cost: 1 seconds
T1 has acquired, cost: 1 seconds
T4 has failed
T9 has failed
T8 has failed
T2 has failed
T6 has failed
T5 has failed
T6 has failed
T5 has failed
T9 has failed
T2 has failed
T8 has failed
T4 has failed
T6 has failed
T8 has acquired, cost: 2 seconds
T2 has acquired, cost: 2 seconds
T5 has failed
T9 has failed
T4 has failed
T6 has failed
T5 has failed
T9 has failed
T4 has failed
T9 has acquired, cost: 3 seconds
T4 has acquired, cost: 3 seconds
T6 has failed
T5 has failed
T5 has failed
T6 has failed
T5 has acquired, cost: 4 seconds
T6 has acquired, cost: 4 seconds
All acquire @ 4 seconds

Test -- 5 permit per 1 seconds
current keys: 
  myLimiter
Test start @ 1686808276466
T0 has acquired, cost: 0 seconds
T2 has acquired, cost: 0 seconds
T1 has acquired, cost: 0 seconds
T3 has acquired, cost: 0 seconds
T5 has failed
T4 has acquired, cost: 0 seconds
T6 has failed
T7 has failed
T8 has failed
T9 has failed
T6 has failed
T8 has failed
T5 has failed
T9 has failed
T7 has failed
T9 has acquired, cost: 1 seconds
T5 has acquired, cost: 1 seconds
T7 has acquired, cost: 1 seconds
T6 has acquired, cost: 1 seconds
T8 has acquired, cost: 1 seconds
All acquire @ 1 seconds

Test -- 100 permit per 1 seconds
current keys: 
  myLimiter
Test start @ 1686808277475
T1 has acquired, cost: 0 seconds
T0 has acquired, cost: 0 seconds
T2 has acquired, cost: 0 seconds
T3 has acquired, cost: 0 seconds
T4 has acquired, cost: 0 seconds
T5 has acquired, cost: 0 seconds
T7 has acquired, cost: 0 seconds
T6 has acquired, cost: 0 seconds
T8 has acquired, cost: 0 seconds
T9 has acquired, cost: 0 seconds
All acquire @ 0 seconds

Test -- 200 permit per 1 seconds
current keys: 
  myLimiter
Test start @ 1686808277476
T0 has acquired, cost: 0 seconds
T1 has acquired, cost: 0 seconds
T3 has acquired, cost: 0 seconds
T2 has acquired, cost: 0 seconds
T4 has acquired, cost: 0 seconds
T5 has acquired, cost: 0 seconds
T6 has acquired, cost: 0 seconds
T7 has acquired, cost: 0 seconds
T8 has acquired, cost: 0 seconds
T9 has acquired, cost: 0 seconds
All acquire @ 0 seconds
current keys: 
  {myLimiter}:value
  myLimiter
  {myLimiter}:permits
```
