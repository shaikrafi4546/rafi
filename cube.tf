provider "aws" {
  region     = "us-east-1"
}

# Create a bucket
resource "aws_s3_bucket" "b1" {

  bucket = "s3-rebelisam-bucket"

  acl    = "private"   # or can be "public-read"

  tags = {

    Name        = "My bucket"

    Environment = "Dev"

  }

}
