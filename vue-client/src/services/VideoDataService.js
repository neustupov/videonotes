import http from "../http-common";

class VideoDataService {
  getAll(board, sticker, note) {
    return http.get(`/${board}/${sticker}/${note}`);
  }
}

export default new VideoDataService();