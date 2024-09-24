package lzl.com.sort;

public class Merge {
    public static void main(String[] args) {

    }
    //region 数组排序
    public static int[] mergeSort(int[] array) {
        return doMergeSort(array, 0, array.length - 1);
    }

    private static int[] doMergeSort(int[] array, int l, int r) {
        if (l == r) {
            return new int[]{array[l]};
        }
        int mid = l + (r - l) / 2;
        int[] leftArray = doMergeSort(array, l, mid);
        int[] rightArray = doMergeSort(array, mid + 1, r);
        return merge(leftArray, rightArray);
    }

    private static int[] merge(int[] leftArray, int[] rightArray) {
        int[] targetArray = new int[leftArray.length + rightArray.length];
        int i = 0;
        int pl = 0, pr = 0;
        while (i < targetArray.length) {
            if (pl < leftArray.length && (pr == rightArray.length || (leftArray[pl] < rightArray[pr]))) {
                targetArray[i++] = leftArray[pl++];
            }
            if (pr < rightArray.length && (pl == leftArray.length || leftArray[pl] >= rightArray[pr])) {
                targetArray[i++] = rightArray[pr++];
            }
        }
        return targetArray;
    }
    //endregion

    //region 链表排序
    public static ListNode sortList(ListNode head) {
        // 单个元素
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMid(head);
        ListNode next = mid.next;
        mid.next = null;
        ListNode rightNode = sortList(next);
        ListNode leftNode = sortList(head);
        return mergeList(leftNode, rightNode);
    }

    /**
     * 找到中点，fast从head.next开始，返回的是偏向右边的中点，从head开始，返回偏向左边的中点
     */
    private static ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static ListNode mergeList(ListNode leftNode, ListNode rightNode) {
        ListNode virtualNode = new ListNode();
        ListNode node = virtualNode;
        while (leftNode != null && rightNode != null) {
            if (leftNode.val < rightNode.val) {
                node.next = leftNode;
                leftNode = leftNode.next;
            } else {
                node.next = rightNode;
                rightNode = rightNode.next;
            }
            node = node.next;
        }
        if (leftNode == null) {
            node.next = rightNode;
        } else {
            node.next = leftNode;
        }
        return virtualNode.next;
    }
    //endregion


    // region inversion count
    // TODO：归并的模版题
    // endregion
}