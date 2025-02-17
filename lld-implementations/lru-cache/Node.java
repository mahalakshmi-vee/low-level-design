class Node {
        private int key;
        private int value;
        private Node next;
        private Node previous;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
            this.previous = null;
        }
        public int getKey() {
            return this.key;
        }
        public int getValue() {
            return this.value;
        }
        public Node getNext() {
            return this.next;
        }
        public Node getPrevious() {
            return this.previous;
        }
        public void setValue(int value) {
            this.value = value;
        }
        public void setNext(Node next) {
            this.next = next;
        }
        public void setPrevious(Node previous) {
            this.previous = previous;
        }
    }
