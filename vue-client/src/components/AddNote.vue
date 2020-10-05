<template>
  <div class="submit-form">
    <div class="form-group">
      <label for="title">Title</label>
      <input
          type="text"
          class="form-control"
          id="title"
          required
          v-model="note.title"
          name="title"
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
          title: "",
          stickerId: null
        }
      };
    },
    methods: {
      saveNote() {
        var data = {
          title: this.note.title,
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