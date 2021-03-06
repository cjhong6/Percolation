# Percolation
<p>Given a composite systems comprised of randomly distributed insulating and metallic materials: what fraction of the materials need to be metallic so that the composite system is an electrical conductor? Given a porous landscape with water on the surface (or oil below), under what conditions will the water be able to drain through to the bottom (or the oil to gush through to the surface)? Scientists have defined an abstract process known as percolation to model such situations.</p>
<p>Percolation has all kinds of amazing applications, such as the spread of disease, the spread of gossip on the web, and even the spread of intelligent life in the universe.</p>
<h1>The model</h1>
<p>We model a percolation system using an N-by-N grid of sites. Each site is either open or blocked. A full site is an open site that can be connected to an open site in the top row via a chain of neighboring (left, right, up, down) open sites. We say the system percolates if there is a full site in the bottom row. In other words, a system percolates if we fill all open sites connected to the top row and that process fills some open site on the bottom row. (For the insulating/metallic materials example, the open sites correspond to metallic materials, so that a system that percolates has a metallic path from top to bottom, with full sites conducting. For the porous substance example, the open sites correspond to empty space through which water might flow, so that a system that percolates lets water fill open sites, flowing from top to bottom.)</P>
<img src="https://sp19.datastructur.es/materials/hw/hw2/images/percolates.png" alt="example">
<h1>Problem</h1>
<p>In a famous scientific problem, researchers are interested in the following question: if sites are independently set to be open with probability p (and therefore blocked with probability 1 − p), what is the probability that the system percolates? When p equals 0, the system does not percolate; when p equals 1, the system percolates. The plots below show the site vacancy probability p versus the percolation probability for 20-by-20 random grid (top) and 100-by-100 random grid (bottom).</p>
<img src="https://sp19.datastructur.es/materials/hw/hw2/images/percolation-threshold20.png" alt="example">
<img src="https://sp19.datastructur.es/materials/hw/hw2/images/percolation-threshold100.png" alt="example">
<p>When N is sufficiently large, there is a threshold value p∗ such that when p < p∗ a random N-by-N grid almost never percolates, and when p>p∗, a random N-by-N grid almost always percolates. No mathematical solution for determining the percolation threshold p∗ has yet been derived. Your task is to write a computer program to estimate p∗.</p>

<h1>Running the Program</h1>
<p>Interactive Visualization client</p>
<p>InteractivePercolationVisualizer.java animates the results of opening sites in a percolation system, using the mouse as input. It takes a command-line integer N that specifies the grid size.</p>
<p>java hw2/InteractivePercolationVisualizer</p>


