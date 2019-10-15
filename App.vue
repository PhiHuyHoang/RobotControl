<template>
  <view class="container">
    <Statusbar color="#FF0000" />
    <Header title="Robot Control" />

  <view class="todo" v-for="todo in todos.slice().reverse()" :key="todo.id">
   <touchable-opacity :on-press="() => addText(todo.id)">
   <text class="todo-text" v-if="todo.done">{{todo.name}} is checked!</text>
   <text class="todo-text" v-else>{{todo.name}}</text>
   </touchable-opacity>
  </view>

  </view>
</template>


<script>
import Statusbar from './components/Statusbar';
import Header from './components/Header';
import axios from 'axios';

export default {
    
  components: {
    Statusbar,
    Header
  },

  data() {
    return {
      todos: [
        {
          id: 0,
          name: "Rice, you're awesome! ≧◡≦ ",
          done: false
        }
      ]
    }
  },
  mounted() {
    axios.get('http://10.0.75.1:8080/JavaAPI/robotapi')
    .then(response => (this.todos = response.data));
  },
  methods: {
    addText(id) {
      this.todos = this.todos.map(todo => {
        if(todo.id == id)
        
          todo.done = !todo.done;       
          return todo;
        
      })
    }
  }
}

</script>

<style>
.container {
  background-color: white;
  flex: 1;
}

.todo {
  flex-direction: row;
  justify-content: space-between;
  padding: 15px;
}

.todo-text {
  font-size: 18px;
  align-content: center;
}

</style>
