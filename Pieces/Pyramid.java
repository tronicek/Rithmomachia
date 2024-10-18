public class Pyramid extends Piece {
  private List<GamePiece> pyramidLayers; // List of pieces representing the pyramid layers

    public PyramidPiece() {
        super(0); // Pyramid itself doesn't have a single independent value
        this.pyramidLayers = new ArrayList<>();
    }

    // Add a layer to the pyramid
    public void addLayer(GamePiece piece) {
        pyramidLayers.add(piece);
    }

    // Remove a specific layer from the pyramid
    public void removeLayer(GamePiece piece) {
        pyramidLayers.remove(piece);
    }

    // Take a specific layer from the pyramid independently
    public GamePiece takeLayer(GamePiece piece) {
        if (pyramidLayers.contains(piece)) {
            removeLayer(piece); // Remove from pyramid
            return piece; // Return the taken piece
        }
        return null; // Piece not found
    }

    // Get all layers of the pyramid
    public List<GamePiece> getLayers() {
        return new ArrayList<>(pyramidLayers); // Return a copy
    }

    public boolean isEmpty() {
        return pyramidLayers.isEmpty();
    }
}
