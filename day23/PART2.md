Raw instructions:

    set b 57
    set c b
    jnz a 2
    jnz 1 5
    mul b 100
    sub b -100000
    set c b
    sub c -17000
    set f 1
    set d 2
    set e 2
    set g d
    mul g e
    sub g b
    jnz g 2
    set f 0
    sub e -1
    set g e
    sub g b
    jnz g -8
    sub d -1
    set g d
    sub g b
    jnz g -13
    jnz f 2
    sub h -1
    set g b
    sub g c
    jnz g 2
    jnz 1 3
    sub b -17
    jnz 1 -23

Instructions numbered, custom instructions subbed, loops identified:

    // New instructions: "add"; "jump not zero to", "jump greater than zero to".
    
     1. set   b 57
     2. set   c b
     3. jnzto a 5
     4. jmpto 9
     5. mul   b 100
     6. add   b 100000
     7. set   c b
     8. add   c 17000
         9. set   f 1
        10. set   d 2
            11. set   e 2
                12. set   g d
                13. mul   g e
                14. sub   g b
                15. jnzto g 17
                    16. set   f 0
                17. add   e 1
                18. set   g e
                19. sub   g b
                20. jnzto g 12
            21. add   d 1
            22. set   g d
            23. sub   g b
            24. jnzto g 11
        25. jnzto f 27
            26. add   h 1
        27. set   g b
        28. sub   g c
        29. jnzto g 31
            30. end
        31. add   b 17
        32. jmpto 9

First pass at pseudo-code:

    // Observation: g is only used to temporarily hold calculation results.
    
    var b = 105700
    var c = 122700
    var h = 0
    
    while (true) {
        var f = 1
        var d = 2
    
        while (d - b != 0) {
            var e = 2
    
            while (e - b != 0) {
                if (d * e - b != 0) {
                    f = 0
                }
    
                e += 1
            }
    
            d += 1
        }
    
        if (f == 0) h += 1
    
        if (b - c == 0) break
        b += 17
    }

Convert while loops to for loops, rename some vars:

    var count = 0
    
    for (b in 105700..122700 step 17) {
        var flag = 1
    
        for (d in 2 until b) {
            for (e in 2 until b) {
                if (d * e == b) {
                    flag = 0
                }
            }
        }
    
        if (flag == 0) count += 1
    }

Identify and optimize core algorithm:

    var count = 0
    
    for (b in 105700..122700 step 17) {
        if (isNotPrime(b)) {
            count += 1
        }
    }

Final optimized Kotlin code:

    // Relies on a custom extension function Int.isNotPrime.
    
    (105700..122700 step 17).count(Int::isNotPrime)
