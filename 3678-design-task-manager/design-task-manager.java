class KeyValue{
    public int key;
    public int value;
    public KeyValue(int key, int value){
        this.key = key;
        this.value = value;
    }
}

class TaskManager {
    public TreeSet<KeyValue> set;
    public Map<Integer,Integer> map;
    public List<Integer> list;
    public Map<Integer, KeyValue> keyMap;
    public KeyValue obj;

    public TaskManager(List<List<Integer>> task) {
        set = new TreeSet<>((a,b)->{
            int c = Integer.compare(b.value,a.value);
            if(c==0) return Integer.compare(b.key,a.key);
            return c;
        });
        map = new HashMap<>();
        keyMap = new HashMap<>();
        for(int i=0;i<task.size();i++){
            int userId = task.get(i).get(0);
            int taskId = task.get(i).get(1);
            int prio = task.get(i).get(2);
            obj = new KeyValue(taskId,prio);
            set.add(obj);
            map.put(taskId,userId);
            keyMap.put(taskId,obj);
            
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        obj = new KeyValue(taskId,priority);
        set.add(obj);
        map.put(taskId,userId);
        keyMap.put(taskId,obj);


    }
    
    public void edit(int taskId, int newPriority) {
        obj = keyMap.get(taskId);
        set.remove(obj);
        obj = new KeyValue(taskId, newPriority);
        set.add(obj);
        keyMap.put(taskId,obj);
    }
    
    public void rmv(int taskId) {
        obj = keyMap.get(taskId);
        set.remove(obj);
        keyMap.remove(taskId);
        map.remove(taskId);
    }
    
    public int execTop() {
        if(set.isEmpty()) return -1;
        return map.get(set.pollFirst().key);
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */