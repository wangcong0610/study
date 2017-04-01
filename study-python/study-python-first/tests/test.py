#!/usr/bin/python3
# -*- coding: UTF-8 -*-


# ### 连续赋值
# a=b=c=1
# c=2
# print(a)
# del(b)
# print(b)



# ### 字符串
# str='abcdefghijklmnopqrstuvwxyz'
# print(str[1:3])
# print(str[1:1+2])



# ###判断1
# a=10
# b=20
# print(a == b)
# print(a < b)
# print(a > b)
# print((a == b) == False)



# ###判断2
# age = int(input("请输入你家狗狗的年龄: "))
# print("")
# if age < 0:
# 	print("你是在逗我吧!")
# elif age == 1:
# 	print("相当于 14 岁的人。")
# elif age == 2:
# 	print("相当于 22 岁的人。")
# elif age > 2:
# 	human = 22 + (age -2)*5
# 	print("对应人类年龄: ", human)
### 退出提示
# input("点击 enter 键退出")



# ### 迭代器1
# list=[1,2,3,4]
# it = iter(list)    # 创建迭代器对象
# for x in it:
#     print (x, end=", ")



# ### 迭代器2
# import sys         # 引入 sys 模块
# list=[1,2,3,4]
# it = iter(list)    # 创建迭代器对象
# while True:
#     try:
#         print (next(it))
#     except StopIteration:
#         print ("asfdasf")
#         sys.exit()



# ### 生成器
# import sys
# import traceback
# def fibonacci(n): # 生成器函数 - 斐波那契
#     if n < 0:
#         raise Exception("n应该大于0！")
#     a, b, counter = 0, 1, 0
#     while True:
#         if (counter > n): 
#             return
#         yield a
#         a, b = b, a + b
#         counter += 1
# try:
#     f = fibonacci(10) # f 是一个迭代器，由生成器返回生成
# except Exception as e:
#     print (e.message)
#     sys.exit
# while True:
#     try:
#         print (next(f), end=" ")
#     except StopIteration as e:
#         print (e.message)
#         sys.exit()



# ### 线程 _thread
# import _thread
# import time
# def print_time(threadName, sleepTime): # 线程函数
#     count = 0
#     while count < 5 :
#         time.sleep(delay)
#         count += 1
#         print("%s: %s" % (threadName, time.ctime(time.time())))
# def print_thread_name(threadName): # 线程函数
#     print(threadName)
# try:
#     print_thread_name("asdfaf")
#     _thread.start_new_thread(print_thread_name, ("Thread-1", ))
#     _thread.start_new_thread(print_time, ("Thread-1", 2))
#     print("创建线程完成")
# except:
#     print("Error: 无法创建线程")





# ### 线程 threading
# import threading
# import time
# exitFlag = 0
# class myThread (threading.Thread):
#     def __init__(self, threadID, threadName, counter):
#         threading.Thread.__init__(self)
#         self.threadID = threadID
#         self.name = threadName
#         self.counter = counter
#     def run(self):
#         print("开始线程：" + self.name)
#         print_time(self.name, self.counter, 10)
#         print("结束线程：" + self.name)
# def print_time(threadName, sleepTime, counter):
#     while counter:
#         if exitFlag:
#             return
#         time.sleep(sleepTime)
#         print("%s: %s" % (threadName, time.ctime(time.time())))
#         counter -= 1
# # 创建线程
# thread1 = myThread(1, "Thread-1", 1)
# thread2 = myThread(2, "Thread-2", 2)
# # 启动线程
# thread1.start()
# thread2.start()
# print("主线程开始休眠")
# mainSleepTime = 5
# while mainSleepTime:
#     time.sleep(1)
#     mainSleepTime -= 1
# print("主线程结束休眠")
# exitFlag = 1
# thread1.join()
# thread2.join()
# print("退出主线程")






# ### 线程同步
# import threading
# import time
# class myThread (threading.Thread) :
#     def __init__ (self, threadID, name, counter):
#         threading.Thread.__init__(self)
#         self.threadID = threadID
#         self.name = name
#         self.counter = counter
#     def run(self):
#         print("开启线程：" + self.name)
#         # 获取锁，用户线程同步
#         threadLock.acquire()
#         print_time(self.name, self.counter, 3)
#         # 释放锁，开启下一个线程
#         threadLock.release()
# def print_time(threadName, delay, counter):
#     while counter:
#         time.sleep(delay)
#         print("%s: %s" % (threadName, time.ctime(time.time())))
#         counter -= 1
# threadLock = threading.Lock()
# threads = []
# # 创建新线程
# thread1 = myThread(1, "Thread-1", 1)
# thread2 = myThread(2, "Thread-2", 2)
# # 开启新线程
# thread1.start()
# thread2.start()
# # 添加线程到线程列表
# threads.append(thread1)
# threads.append(thread2)
# # 等待所有线程完成
# for t in threads:
#     t.join()
# print("退出主线程")







# ### 队列Queue (FIFO)
# import queue
# import threading
# import time
# exitFlag = 0
# class myThread(threading.Thread):
#     def __init__(self, threadID, name, q):
#         threading.Thread.__init__(self)
#         self.threadID = threadID
#         self.name = name
#         self.q = q
#     def run(self):
#         print("开启线程：" + self.name)
#         process_data(self.name, self.q)
#         print("退出线程：" + self.name)
# def process_data(threadName, q):
#     while not exitFlag:
#         queueLock.acquire()
#         if not workQueue.empty():
#             data = q.get()
#             queueLock.release()
#             print("%s processing %s" % (threadName, data))
#         else:
#             queueLock.release()
#         time.sleep(1)
# threadList = ["Thread-1", "Thread-2", "Thread-3"]
# nameList = ["One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"]
# queueLock = threading.Lock()
# workQueue = queue.Queue(10)
# threads = []
# threadID = 1
# # 创建新线程
# for tName in threadList:
#     thread = myThread(threadID, tName, workQueue)
#     thread.start()
#     threads.append(thread)
#     threadID += 1
# # 填充队列
# queueLock.acquire()
# for word in nameList:
#     workQueue.put(word)
# queueLock.release()
# # 等待队列清空
# while not workQueue.empty():
#     pass
# # 通知线程退出
# exitFlag = 1
# # 等待所有线程完成
# for t in threads:
#     t.join()
# print("主线程完成工作");





# ### Json
# import json
#
# # Python 字典转换为JSON对象
# data = {
#     'no': 1,
#     'name': 'xiaomi',
#     'url': 'www.mi.com'
# }
# json_str = json.dumps(data)
# print("Python 数据为：", repr(data))
# print("JSON 对象：", json_str)






# ### 获取当前时间
# ### 获取当前时间
# import time
# localTime = time.localtime(time.time())
# print("本地时间为：", localTime)






### 格式化的时间
# import time
# localtime = time.asctime(time.localtime(time.time()))
# print("本地时间为：", localtime)




# ### 格式化日期
# import time
# # 格式化为yyyy-MM-dd HH:mm:ss 形式
# print(time.strftime("%Y-%m-%d %H:%M:%S", time.localtime(time.time())))
# # 格式化为Fri Mar 24 15:01:41 2017形式
# print(time.strftime("%a %b %d %H:%M:%S %Y", time.localtime()))
# # 将格式字符串转换为时间戳
# a = "Sat Mar 28 22:24:24 2016"
# print (time.mktime(time.strptime(a,"%a %b %d %H:%M:%S %Y")))





# ### 获取日历
# import calendar
# cal = calendar.month(2017, 3)
# print(cal)






# ### 输出指定范围内的素数
# lower = int(input("输入区间最小值："))
# upper = int(input("输入区间最大值："))
# for num in range(lower, upper + 1):
#     # 素数大于1
#     if num > 1 :
#         for i in range(2, int(num/2) + 1):
#             if(num % i) == 0:
#                 break
#         else:
#             print(num)
