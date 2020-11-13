class Solution:
    def findMedianSortedArrays(self, nums1, nums2):
        if not (len(nums1) == 0 and len(nums2) == 0):
            # nums1, nums2 = eval(input('input0')), eval(input('input1'))
            nums1 = sorted(nums1 + nums2)
            len0 = (len(nums1)-1) // 2
            if len(nums1) % 2 != 0:
                result0 = (nums1[len0])
            else:
                result0 = ((nums1[len0] + nums1[len0+1]) / 2)
            return result0


if __name__ == '__main__':
    so00 = Solution()
    ls00, ls01 = [3, 4, 1, 2], [7, 6, 5]
    result00 = so00.findMedianSortedArrays(ls00, ls01)
    print(result00)
