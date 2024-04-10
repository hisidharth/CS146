class Flood:
    def floodFill(self, image, sr, sc, newColor):
        if not image or len(image) == 0 or len(image[0]) == 0 or sr < 0 or sr >= len(image) or sc < 0 or sc >= len(image[0]):
            return image
        og = image[sr][sc]
        if og == newColor:
            return image
        self.dfs(image, sr, sc, og, newColor)
        return image

    def dfs(self, image, r, c, og, newColor):
        if r < 0 or r >= len(image) or c < 0 or c >= len(image[0]) or image[r][c] != og:
            return
        image[r][c] = newColor
        self.dfs(image, r + 1, c, og, newColor)
        self.dfs(image, r - 1, c, og, newColor)
        self.dfs(image, r, c + 1, og, newColor)
        self.dfs(image, r, c - 1, og, newColor)

if __name__ == "__main__":
    flood = Flood()
    image = [[0, 1, 1], [1, 0, 0], [1, 0, 1]]
    sr, sc, newColor = 2, 1, 2

    result = flood.floodFill(image, sr, sc, newColor)
    for row in result:
        print(" ".join(map(str, row)))
