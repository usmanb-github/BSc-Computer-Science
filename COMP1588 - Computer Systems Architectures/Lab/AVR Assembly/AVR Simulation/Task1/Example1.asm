ldi   r16,$04    ;Line 1 - Put 04 HEX into register r16 
      ldi   r17,$06    ;Line 2 - Put 06 HEX into register r17 
      ldi   r18,$01    ;Line 3 - Put 01 HEX into register r18 
      ldi   r19,$F8    ;Line 4 - Put F8 HEX into register r19 
      add   r16,r17    ;Line 5 - Add contents of r16 to r17 and put the total in r16 
      sub   r16,r18    ;Line 6 - Subtract the contents of r18 from the total in r16 and put the answer in r16 
      add   r16,r19    ;Line 7 - Add the contents of r16 to r19 and put the total in r16 

end:  rjmp  end        ;loop forever 
