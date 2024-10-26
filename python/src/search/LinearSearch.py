# 线性查找

from typing import List


def linear_search(nums: List[int], target: int) -> int:
    """ 线性查找，无预设条件，时间复杂度：O(n)

    :param nums: 待查找数组
    :param target: 查找元素
    :return: target 在该数组中的索引。若数组不包含该元素，则返回 −1
    """

    for i in range(len(nums)):
        if nums[i] == target:  # 找到目标元素，返回其索引
            return i

    return -1  # 未找到目标元素，返回 -1
