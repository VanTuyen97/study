from datetime import *


def date_format():
    """
    YYYY = four-digit year
    MM   = two-digit month (01=January, etc.)
    DD   = two-digit day of month (01 through 31)
    hh   = two digits of hour (00 through 23) (am/pm NOT allowed)
    mm   = two digits of minute (00 through 59)
    ss   = two digits of second (00 through 59)
    s    = one or more digits representing a decimal fraction of a second
    TZD  = time zone designator (Z or +hh:mm or -hh:mm)
    """
    cur = datetime.now()
    print('{:%d-%m-%Y}'.format(cur))


if __name__ == '__main__':
    date_format()