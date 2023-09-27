package class05;

// 这道题直接在leetcode测评：
// https://leetcode.com/problems/count-of-range-sum/
public class Code01_CountOfRangeSum {

	public static int countRangeSum(int[] nums, int lower, int upper) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		long[] sum = new long[nums.length];
		sum[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			sum[i] = sum[i - 1] + nums[i];
		}
		return process(sum, 0, sum.length - 1, lower, upper);
	}

	public static int process(long[] sum, int L, int R, int lower, int upper) {
		if (L == R) {
			return sum[L] >= lower && sum[L] <= upper ? 1 : 0;
		}
		int M = L + ((R - L) >> 1);
		return process(sum, L, M, lower, upper) + process(sum, M + 1, R, lower, upper)
				+ merge(sum, L, M, R, lower, upper);
	}

	public static int merge(long[] arr, int L, int M, int R, int lower, int upper) {
		int ans = 0;
		int windowL = L;
		int windowR = L;
		// [windowL, windowR) ,不需要考虑超过中点的情况，因为左端点超过中点的话，已经属于右半侧
		//在右侧统计，对右侧每个数
		//这里实际上是看区间和的右端点在右侧，区间和的左端点在左侧有多少个
		for (int i = M + 1; i <= R; i++) {
			long min = arr[i] - upper;//区间左边必须比这个大,才能让区间和<=upper
			long max = arr[i] - lower; //区间右边最多这么大,才能让区间和>=lower
			//这里实际上就是arr[右端点]-arr[左端点] 属于[lower,upper]。要记住这里arr是前缀和数组

			// 下面实际上找左侧的下标位置，看哪一个可以和当前右侧的i配对
//			while (windowR <= M && arr[windowR] <= max) {
//				windowR++;
//			}
//			while (windowL <= M && arr[windowL] < min) {
//				windowL++;
//			}
			//如果和一直大于lower,就一直往右移动。直到不满足，则windowR是区间和条件的下一个
			while (windowR <=M && arr[i] - arr[windowR] >= lower ){
				windowR++;
			}
			// 大于upper就一直往右移动,这个差是不断减小的。所以最终退出条件是区间和的左端点
			while (windowL <= M && arr[i] - arr[windowL] > upper){
				windowL++;
			}


			//在这个窗口内的都算(l1,i) (l2,i)... 当l1,l2都属于[windowL,windowR)
			ans += windowR - windowL;
		}
		//归并排序过程
		long[] help = new long[R - L + 1];
		int i = 0;
		int p1 = L;
		int p2 = M + 1;
		while (p1 <= M && p2 <= R) {
			help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
		}
		while (p1 <= M) {
			help[i++] = arr[p1++];
		}
		while (p2 <= R) {
			help[i++] = arr[p2++];
		}
		//copy help数组
		for (i = 0; i < help.length; i++) {
			arr[L + i] = help[i];
		}
		return ans;
	}
	//用左侧来统计右侧
	public static int merge2(long[] arr, int L, int M, int R, int lower, int upper) {
		int ans = 0;
		int windowL = L;
		int windowR = L;
		// [windowL, windowR) ,不需要考虑超过中点的情况，因为左端点超过中点的话，已经属于右半侧
		//在右侧统计，对右侧每个数
		//这里实际上是看区间和的右端点在右侧，区间和的左端点在左侧有多少个
		for (int i = M + 1; i <= R; i++) {
			long min = arr[i] - upper;//区间左边必须比这个大,才能让区间和<=upper
			long max = arr[i] - lower; //区间右边最多这么大,才能让区间和>=lower
			//这里实际上就是arr[右端点]-arr[左端点] 属于[lower,upper]。要记住这里arr是前缀和数组

			// 下面实际上找左侧的下标位置，看哪一个可以和当前右侧的i配对
//			while (windowR <= M && arr[windowR] <= max) {
//				windowR++;
//			}
//			while (windowL <= M && arr[windowL] < min) {
//				windowL++;
//			}
			//如果和一直大于lower,就一直往右移动。直到不满足，则windowR是区间和条件的下一个
			while (windowR <=M && arr[i] - arr[windowR] >= lower ){
				windowR++;
			}
			// 大于upper就一直往右移动,这个差是不断减小的。所以最终退出条件是区间和的左端点
			while (windowL <= M && arr[i] - arr[windowL] > upper){
				windowL++;
			}


			//在这个窗口内的都算(l1,i) (l2,i)... 当l1,l2都属于[windowL,windowR)
			ans += windowR - windowL;
		}
		//归并排序过程
		long[] help = new long[R - L + 1];
		int i = 0;
		int p1 = L;
		int p2 = M + 1;
		while (p1 <= M && p2 <= R) {
			help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
		}
		while (p1 <= M) {
			help[i++] = arr[p1++];
		}
		while (p2 <= R) {
			help[i++] = arr[p2++];
		}
		//copy help数组
		for (i = 0; i < help.length; i++) {
			arr[L + i] = help[i];
		}
		return ans;
	}

}
