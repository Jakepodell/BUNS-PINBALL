public final static int Y=0;
	public final static int WIDTH=350;
	public final static int HEIGHT=500;
	//System.out.println("Fdsf");
	LeftFlipper lf = new LeftFlipper(LeftFlipper.X,Flipper.Y);
	RightFlipper rf = new RightFlipper(RightFlipper.X,Flipper.Y);
	Flipper[] flips = {rf,lf};
	ScorePanel sp;
	public Board(int xcord, int ycord, int height, int width)
	{
		super(xcord,ycord,height,width);
	}
	public Board(ScorePanel sp){
		super(X+PinballDriver.APPLETPADDING,
		Y+PinballDriver.APPLETPADDING,
		WIDTH,
		HEIGHT);
		this.sp=sp;
		bumpers.add(new Bumper((int)(getX()+Board.WIDTH/2-30),200));
		bumpers.add(new Bumper((int)(getX()+Board.WIDTH/2+30),200));
		bumpers.add(new Bumper((int)(getX()+Board.WIDTH/2),150));
		bumpers.add(new Bumper((int)(getX()+Board.WIDTH/2-135),300));
		bumpers.add(new Bumper((int)(getX()+Board.WIDTH/2-90),300));
		bumpers.add(new Bumper((int)(getX()+Board.WIDTH/2+135),300));
		bumpers.add(new Bumper((int)(getX()+Board.WIDTH/2+90),300));
		bumpers.add(new Bumper((int)(getX()+Board.WIDTH/2-90),100));
		bumpers.add(new Bumper((int)(getX()+Board.WIDTH/2+90),100));
		bumpers.add(new Bumper((int)(getX()+Board.WIDTH/2),250));
		bumpers.add(new Bumper((int)(getX()+Board.WIDTH/2-135),100));
		bumpers.add(new Bumper((int)(getX()+Board.WIDTH/2+135),100));
		bumpers.add(new Bumper((int)(getX()+Board.WIDTH/2-150),225));
		bumpers.add(new Bumper((int)(getX()+Board.WIDTH/2+150),225));
	}
	public void drawBoard(Graphics2D g)
	{
		g.draw(this);
		drawBottom(g);
		//g.draw(ball);
		ball.drawBall(g);
		lf.drawFlip(g);
		rf.drawFlip(g);
		for(Bumper bumper:bumpers)
			bumper.drawBumper(g);
		//g.fill(lf.getCollisionArea());
		//g.fill(rf.getCollisionArea());
	}
	public void checkFlipperCollision(){
		Collision.checkFlipperCollision(flips,ball,sp);
	}
	public void update(){
		for(int i =0; i<Math.abs(ball.getXVelocity()); i++){
			Collision.checkBoardIntersection(this,ball);
			Collision.checkBumperCollision(bumpers,ball,sp);
			Collision.checkStaticFlipperCollision(lf,rf,ball);
			ball.moveHoriz();

		}
		for(int i =0; i<Math.abs(ball.getYVelocity()); i++){
			Collision.checkBoardIntersection(this,ball);
			Collision.checkBumperCollision(bumpers,ball,sp);
			Collision.checkStaticFlipperCollision(lf,rf,ball);
			ball.moveVert();
		}
		ball.gravitize();
		if(Collision.ballHasFallen(ball)){
			ballIndex++;
			ball=balls[ballIndex];
			sp.loseLife();
		}
	}
	public int getRightSide(){
		return WIDTH+PinballDriver.APPLETPADDING;
	}
	public int getLeftSide(){
		return PinballDriver.APPLETPADDING;
	}
	public int getTopSide(){
		return PinballDriver.APPLETPADDING;
	}
	public int getBottomSide(){
		return PinballDriver.APPLETPADDING+HEIGHT;
	}
	public Flipper getLeftFlipper(){
		return (Flipper)lf;
	}
	public Flipper getRightFlipper(){
			return (Flipper)rf;
	}
	public void drawBottom(Graphics2D g){
		g.drawLine(getBoardX(), Flipper.Y,LeftFlipper.X, Flipper.Y);
		g.drawLine(RightFlipper.X, Flipper.Y,getBoardX()+Board.WIDTH, Flipper.Y);
	}
	public int getBoardX(){
		return (int)(X+PinballDriver.APPLETPADDING);
	}
	public int getBoardY(){
			return (int)(Y+PinballDriver.APPLETPADDING);
	}
}
