package class01;

/**
 * 只要可以丢掉一部分，就可以用二分
 */
public class Code06_BSAwesome {
	/**
	 * 问题:求一个局部最小的数，如果这个数比左边小，同时比右边小.第一个数和最后一个数只需要满足一个条件就可以。
	 * 输入：这个数组是无序的，任意2个数不相等
	 * @param arr
	 * @return
	 */
	// 课上的代码,
	public static int getLessIndex(int[] arr) {
		if (arr == null || arr.length == 0) {
			return -1;
		}
		//先单独检查第一个数和最后一个数,这个或包含了长度为2的情况
		if (arr.length == 1 || arr[0] < arr[1]) {
			return 0;
		}
		if (arr[arr.length - 1] < arr[arr.length - 2]) {
			return arr.length - 1;
		}
		//在上面2个都没有满足，则表示数组是先减 ...  增.在中间范围内一定有局部最小，所以直接取中点位置，然后将这个递增递减关系继续下。画个图示就好理解了
		//就是取中点，然后流程可以证明是对的
		int left = 1;
		int right = arr.length - 2;
		int mid = 0;
		while (left < right) {
			mid = (left + right) / 2;
			//画图就很好理解
			//如果中间的比左边大，则取左边
			if (arr[mid] > arr[mid - 1]) {
				right = mid - 1;
			} else if (arr[mid] > arr[mid + 1]) {
				left = mid + 1;
			} else {
				return mid;
			}
		}
		return left;
	}

	// 验证得到的结果，是不是局部最小
	public static boolean isRight(int[] arr, int index) {
		if (arr.length <= 1) {
			return true;
		}
		if (index == 0) {
			return arr[index] < arr[index + 1];
		}
		if (index == arr.length - 1) {
			return arr[index] < arr[index - 1];
		}
		return arr[index] < arr[index - 1] && arr[index] < arr[index + 1];
	}

	// 为了测试
	// 生成相邻不相等的数组
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) (Math.random() * maxSize) + 1];
		arr[0] = (int) (Math.random() * maxValue) - (int) (Math.random() * maxValue);
		for (int i = 1; i < arr.length; i++) {
			do {
				arr[i] = (int) (Math.random() * maxValue) - (int) (Math.random() * maxValue);
			} while (arr[i] == arr[i - 1]);
		}
		return arr;
	}

	// 为了测试
	public static void main(String[] args) {
		int testTime = 500000;
		int maxSize = 30;
		int maxValue = 100;
		System.out.println("测试开始");
		for (int i = 0; i < testTime; i++) {
			int[] arr = generateRandomArray(maxSize, maxValue);
			int ans = getLessIndex(arr);
			if (!isRight(arr, ans)) {
				System.out.println("出错了！");
				break;
			}
		}
		System.out.println("测试结束");
		System.out.println(getLessIndex(new int[]{1,2}));
	}

}
