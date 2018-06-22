import gevent
import time

import requests
from gevent import monkey
from gevent.pool import Pool
monkey.patch_all(thread=False)


def foo():
    print('Running in foo')
    gevent.sleep(0)
    print('Explicit context switch to fool')


def bar():
    print('Running to bar')
    gevent.sleep(0)
    print('Implicit context switch to bar')


# gevent.joinall([
#     gevent.spawn(foo),
#     gevent.spawn(bar),
# ])
class Test:
    def taskA(self, param):
        print(param)
        r = requests.get(url='http://www.hao123.com/')
        print(param, r.ok)

    def taskB(self, param):
        print(param)

    def taskC(self, param):
        if (param == 1 or param == 5):
            return param


pool = Pool(20)
params = [1, 2, 3, 4, 5, 6]
test = Test()
# pool.map(test.taskA, params)
# pool.map(test.taskB,params)
ret = pool.map(test.taskC,params)
test = Test()