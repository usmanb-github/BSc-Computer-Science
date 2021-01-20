 ;Program to calculate 3a + 2b - c
.equ   a     =3
.equ   b     =4
.equ   c     =19

      ldi   r16,a
      ldi   r17,b
      ldi   r18,c

;use register r20 to calculate 3a
      ldi   r20,$0
      add   r20,r16
      add   r20,r16
      add   r20,r16

;use register r21 to calculate 2b 
      add   r21,r17
      add   r21,r17

;add 3a to 2b and put the result in r20
	  add   r21,r20
	  ldi   r20, $0	
	  mov   r20, r21
	  ldi   r21, $0
;put c into r22 then take it from the total in r20
      ldi   r22,c
      sub  r22,r20

end:  rjmp  end     ;loop forever 
