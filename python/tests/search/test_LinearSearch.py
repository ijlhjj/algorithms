import random
from unittest import TestCase

from search.LinearSearch import *


class Test(TestCase):

    def test_linear_search(self):
        # 线性查找 测试

        limit = 100  # 列表上限
        nums = [n for n in range(limit)]  # 创建列表
        random.shuffle(nums)  # 随机打乱

        # 循环判断每个元素的查找结果符合预期
        for i in range(limit):
            self.assertEqual(i, linear_search(nums, nums[i]))

        # 列表中不包含上限值
        self.assertEqual(-1, linear_search(nums, limit))
