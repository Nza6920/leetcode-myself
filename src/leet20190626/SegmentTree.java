package leet20190626;

public class SegmentTree<E> {

    private E[] data;      // 所有元素数组
    private E[] tree;      // 线段树
    private Merger<E> merger;

    public SegmentTree(E[] arr, Merger<E> merger) {
        this.data = (E[]) new Object[arr.length];
        this.tree = (E[]) new Object[4 * arr.length];
        this.merger = merger;
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }

        // 创建线段树
        buildSegmentTree(0, 0, data.length - 1);
    }

    /**
     * 在 treeIndex 的位置创建表示区间[l.....r]的线段树
     * @param treeIndex 开始位置
     */
    private void buildSegmentTree(int treeIndex, int l, int r) {
        if(l == r){
            tree[treeIndex] = data[l];
            return;
        }

        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        int mid = l + (r - l) / 2;
        buildSegmentTree(leftTreeIndex, l, mid);
        buildSegmentTree(rightTreeIndex, mid + 1, r);

        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    /**
     * 返回区间 [queryL, queryR] 的值
     * @param queryL  左边界
     * @param queryR  右边界
     * @return E
     */
    public E query(int queryL, int queryR) {
        if (queryL < 0 || queryL >= data.length || queryR < 0 || queryR >= data.length || queryL > queryR) {
            throw new IllegalArgumentException("Index 非法!");
        }

        return query(0, 0, data.length - 1, queryL, queryR);
    }

    /**
     * 在以 treeIndex 为根的线段树中 [l, r] 的范围里, 搜索区间 [queryL, queryR] 的值
     * @param treeIndex 根
     * @param l         左边界
     * @param r         右边界
     * @param queryL    左查询边界
     * @param queryR    右查询边界
     * @return  E
     */
    private E query(int treeIndex, int l, int r, int queryL, int queryR){
        // 递归终止条件
        if(l == queryL && r == queryR)
            return tree[treeIndex];

        // 求区间的中间索引
        int mid = l + (r - l) / 2;

        // treeIndex的节点分为[l...mid]和[mid+1...r]两部分
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        // 查询区间在中间点右边
        if(queryL >= mid + 1) {
            return query(rightTreeIndex, mid + 1, r, queryL, queryR);
            // 查询区间在中间点左边
        } else if(queryR <= mid) {
            return query(leftTreeIndex, l, mid, queryL, queryR);
        }

        // 查询区间即在左边也在右边
        E leftResult = query(leftTreeIndex, l, mid, queryL, mid);
        E rightResult = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);
        return merger.merge(leftResult, rightResult);
    }

    /**
     * 获取当前线段树中所有元素的个数
     * @return int
     */
    public int getSize() {
        return data.length;
    }

    /**
     * 获取指定索引的值
     * @param index 下标
     * @return E
     */
    public E get(int index) {
        if (index < 0 || index > data.length) {
            throw new IllegalArgumentException("Index 非法!");
        }

        return data[index];
    }

    /**
     * 返回完全二叉树的数组表示中, 一个索引所表示的左孩子的节点的索引
     * @param index 父节点索引
     * @return  int
     */
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    /**
     * 返回完全二叉树的数组表示中, 一个索引所表示的右孩子的节点的索引
     * @param index 父节点索引
     * @return  int
     */
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append('[');
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null) {
                res.append(tree[i]);
            } else {
                res.append("null");
            }

            if(i != tree.length - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }
}
