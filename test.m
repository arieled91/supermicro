// This is a supermicro program

begin
    read(a1,b2);
    a1 := a1+11.3;

    if(a1>b2 & a1>0)
        b2 := b2-1;
    else
        b2 := 4;
    end

    num := readNum();
    writeNum(num);
    write(a1,(4*b2)/2);
end


writeNum(a)
    write(a);
end

readNum
    read(a);
    return a;
end
