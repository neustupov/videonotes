<template>
  <div class="submit-form">
      <div class="form-group">
        <label for="name">Name</label>
        <input
            type="text"
            class="form-control"
            id="name"
            required
            v-model="board.name"
            name="name"
        />
      </div>
      <button @click="saveBoard" class="btn btn-success">Submit</button>
  </div>
</template>

<script>
  import BoardDataService from "../services/BoardDataService";

  export default {
    name: "add-board",
    data() {
      return {
        board: {
          id: null,
          name: ""
        }
      };
    },
    methods: {
      saveBoard() {
        var data = {
          name: this.board.name,
        };

        BoardDataService.create(data)
        .then(response => {
          this.board.id = response.data.id;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
      },

      newBoard() {
        this.board = {};
      }
    }
  };
</script>

<style>
  .submit-form {
    max-width: 300px;
    margin: auto;
  }
</style>