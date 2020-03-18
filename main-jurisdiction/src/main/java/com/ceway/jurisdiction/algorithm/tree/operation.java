package com.ceway.jurisdiction.algorithm.tree;

public class operation<T>{

    private volatile Node root;

    //添加
    public void insert(int key, T val) {
        // 如果是空树，则插入的节点为根节点
        if (root == null) {
            root = new Node<T>(key, val);
            return;
        }
        insertKV(key,val,root);
    }

    private void insertKV(int key, T val,Node roots){
            if (key < roots.key) { // 如果小于当前节点的值，往左子树查找
                if(roots.left != null){
                    insertKV(key,val,roots.left);
                }else{
                    Node newNode = new Node(key, val);
                    roots = newNode;
                }
            } else if(key == roots.key){
                Node newNode = new Node(key, val);
                roots.left = newNode;
            }else { // 如果大于当前节点的值，往右子树查找
                if(roots.right != null){
                    insertKV(key,val,roots.right);
                }else{
                    Node newNode = new Node(key, val);
                    roots.right = newNode;
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

    //返回最左边子节点
    private  Node findNode(Node node){
        Node pNode = node;
        Node cNode = node;
        while (cNode != null){
            pNode = cNode;
            cNode = cNode.left;
        }
        Node tNode = new tNode(pNode.key,pNode.val);
        if(pNode.right == null){
            pNode = null;
        }else{
            pNode = pNode.right;
        }
        return tNode;
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
            if (root.left == null && root.right == null) {
                root = null;
            } else {
                insert(key,null);
            }
        }

        /**
         * 待删除节点左有值，右为空
         */
        if (findNode.left != null && findNode.right == null) {
            findNode = findNode.left;
        }
        /**
         * 待删除节点右有值，左为空
         */
        if (findNode.left == null && findNode.right != null) {
            findNode = findNode.right;
        }
        /**
         * 待删除节点右左有值
         */
        if (findNode.left != null && findNode.right != null) {
             Node fNode = findNode(findNode);
             findNode.key = fNode.key;
             findNode.val = fNode.val;
        }
        return true;
    }

}
