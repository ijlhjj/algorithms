from unittest import TestCase

from search.BinarySearch import *


class Test(TestCase):

    def test_binary_search(self):
        # 经典二分查找 测试

        limit = 100  # 列表上限
        nums = [n for n in range(limit)]  # 创建列表
        nums.sort()  # 排序，此处创建的列表已有序

        # 循环判断每个元素的查找结果符合预期
        for i in range(limit):
            self.assertEqual(i, binary_search(nums, i))

        # 列表中不包含上限值
        self.assertEqual(-1, binary_search(nums, limit))
