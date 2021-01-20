;flag test program

     ldi    r16,$80
     ldi    r17,$80
     add    r16,r17

     ldi    r16,$78
     ldi    r17,$63
     add    r16,r17

     ldi    r16,$fc
     ldi    r17,$f9
     add    r16,r17

     ldi    r16,252
     ldi    r17,249
     add    r16,r17

end: rjmp   end      ;loop forever
