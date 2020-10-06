<template>
  <div class="submit-form">
    <div class="form-group">
      <label for="description">Description</label>
      <input
          type="text"
          class="form-control"
          id="description"
          required
          v-model="note.description"
          name="description"
      />
    </div>
    <button @click="saveNote" class="btn btn-success">Submit</button>
  </div>
</template>

<script>
  import NoteDataService from "../services/NoteDataService";

  export default {
    name: "add-note",
    data() {
      return {
        note: {
          id: null,
          description: "",
          stickerId: null
        }
      };
    },
    methods: {
      saveNote() {
        var data = {
          description: this.note.description,
          stickerId: this.$route.params.id
        };

        NoteDataService.create(data)
        .then(response => {
          this.note.id = response.data.id;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
      },

      newNote() {
        this.note = {};
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