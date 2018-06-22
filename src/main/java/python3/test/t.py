class T:
    h = 0

    def __init__(self):
        T.h = T.h + 1

    def display(self):
        print T.h

if __name__ == "__main__":
    t1 = T()
    t2 = T()
    t2.display()
    t2.T()