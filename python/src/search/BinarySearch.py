# 二分查找

from typing import List


def binary_search(nums: List[int], target: int) -> int:
    """ 经典二分查找

    :param nums: 待查找数组，已升序排列
    :param target:  查找元素
    :return: target 在该数组中的索引。若数组不包含该元素，则返回 −1
    """

    low = 0
    high = len(nums) - 1

    while low <= high:
        mid = (low + high) // 2
        mid_val = nums[mid]

        if mid_val < target:
            low = mid + 1
        elif mid_val > target:
            high = mid - 1
        else:
            return mid  # 找到目标元素，返回其索引

    return -1  # 未找到目标元素，返回 -1
