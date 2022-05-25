for num in range(1, 101):
    string = ''

    # ここから記述

    # 15の倍数判定
    if num % 15 == 0:
        string = "FizzBuzz"

    # 5の倍数判定
    elif num % 5 == 0:
        string = "Buzz"

    # 3の倍数判定
    elif num % 3 == 0:
        string = "Fizz"

    else:
        string = format(num)

    # ここまで記述

    print(string)
