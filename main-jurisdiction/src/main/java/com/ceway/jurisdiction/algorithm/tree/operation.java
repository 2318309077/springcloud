package com.ceway.jurisdiction.algorithm.tree;

public class operation<T>{

    private volatile Node root;

    //添加
    private void insert(int key, T val) {
        // 如果是空树，则插入的节点为根节点
        if (root == null) {
            root = new Node<T>(key, val);
            return;
        }
        insertKV(key,val,root);
    }

    private void insertKV(int key, T val,Node root){
            if (key < root.key) { // 如果小于当前节点的值，往左子树查找
                if(root.left != null){
                    insertKV(key,val,root.left);
                }else{
                    Node newNode = new Node(key, val);
                    root.left = newNode;
                }
            } else { // 如果大于当前节点的值，往右子树查找
                if(root.right != null){
                    insertKV(key,val,root.right);
                }else{
                    Node newNode = new Node(key, val);
                    root.right = newNode;
                }
            }
    }


    /**
     * 查询该节点是否父节点的左节点
     * @param findNode
     * @param key
     */
    private boolean isParentLeftChildren(Node findNode,int key){
        /**
         * 是否和父节点的左儿子相同
         */
        if (null != findNode.left && findNode.left.key == key){
            return true;
        }else{
            /**
             * 是否和父节点的右儿子相同
             */
            return false;
        }
    }

    //查看
    public Node find(int key){
        /**
         * 从根节点开始找
         */
        Node currentNode = root;

         while (currentNode != null && currentNode.key != key){
             if(key<currentNode.key){
                 currentNode = currentNode.left;
             }else{
                 currentNode = currentNode.right;
             }
         }
         return  currentNode;
    }

    public boolean delete(int key) {
        /**
         * 被查找到的节点
         */
        Node findNode = find(key);

        if (null == findNode) {
            return false;
        }

        /**
         * 待删除节点没有儿子节点
         */
        if (findNode.left == null && findNode.right == null) {
            //判断是否是第一个节点
            if (root.left == null) {
                root = null;
                return true;
            } else {

            }

        }

        return false;
    }

}
