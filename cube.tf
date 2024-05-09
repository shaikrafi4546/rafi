provider "aws" {
  region     = "us-east-1"
  access_key = "AKIA5FTY6W5EKD2DQPUW"
  secret_key = "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"
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
