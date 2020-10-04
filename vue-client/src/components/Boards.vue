<template>
  <div class="list row justify-content-start">
    <!--<div class="col-md-8">
      <div class="input-group mb-3">
        <input type="text" class="form-control" placeholder="Search by title"
               v-model="title"/>
        <div class="input-group-append">
          <button class="btn btn-outline-secondary" type="button"
                  @click="searchName"
          >
            Search
          </button>
        </div>
      </div>
    </div>-->
    <div class="col-md-6">
      <h4>Boards List</h4>
      <ul class="list-group list-group-horizontal">
        <li class="list-group-item shadow-lg m-1 p-3 mb-5 rounded"
            :class="{ active: index === currentIndex }"
            v-for="(board, index) in boards"
            :key="index"
            @click="setActiveBoard(board, index)"
        >
          {{ board.title }}
        </li>
      </ul>

      <!--<button class="m-3 btn btn-sm btn-danger" @click="removeAllBoards">
        Remove All
      </button>-->
    </div>
    <!--<div class="col-md-6">
      <div v-if="currentBoard">
        <h4>Board</h4>
        <div>
          <label><strong>Title:</strong></label> {{ currentBoard.title }}
        </div>

        <a class="badge badge-warning"
           :href="'/boards/' + currentBoard.id + '/stickers'"
        >
          Open
        </a>
      </div>
      <div v-else>
        <br />
        <p>Please click on a Board...</p>
      </div>
    </div>-->
  </div>
</template>

<script>
  import BoardDataService from "../services/BoardDataService";

  export default {
    name: "boards-list",
    data() {
      return {
        boards: [],
        currentBoard: null,
        currentIndex: -1,
        title: ""
      };
    },
    methods: {
      retrieveBoards() {
        BoardDataService.getAll()
        .then(response => {
          this.boards = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
      },

      refreshList() {
        this.retrieveBoards();
        this.currentBoard = null;
        this.currentIndex = -1;
      },

      setActiveBoard(board, index) {
        this.currentBoard = board;
        this.currentIndex = index;
        this.$emit('set-current-board', {
          board: board
        });
      },

      removeAllBoards() {
        BoardDataService.deleteAll()
        .then(response => {
          console.log(response.data);
          this.refreshList();
        })
        .catch(e => {
          console.log(e);
        });
      },

      searchName() {
        BoardDataService.findByTitle(this.title)
        .then(response => {
          this.boards = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
      }
    },
    mounted() {
      this.retrieveBoards();
    }
  };
</script>

<style>
  .list {
    text-align: left;
    max-width: 750px;
    margin: auto;
  }
</style>